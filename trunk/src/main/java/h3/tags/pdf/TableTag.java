package h3.tags.pdf;

import h3.services.DataStoreService;
import h3.state.BaseState;
import h3.state.DataStoreState;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.jelly.JellyTagException;
import org.apache.commons.jelly.MissingAttributeException;
import org.apache.commons.jelly.XMLOutput;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

public class TableTag extends SimplePDFTag {
	private List<Map> columns = new ArrayList<Map>();

	public void addColumn(Map<String, Object> column) {
		columns.add(column);
	}

	@Override
	public void doTag(XMLOutput arg0) throws MissingAttributeException,
			JellyTagException {
		super.doTag(arg0);
		Document doc = (Document) getContext().getVariable("document");
		DataStoreService storeService = (DataStoreService) getContext()
				.getVariable("storeService");
		
		String storeId = (String) getAttrs().get("store");
		String screenName = (String) getContext().getVariable("screenName");
		List<Map<String, Object>> data = (List<Map<String, Object>>) storeService
				.getData(screenName, storeId);
		PdfPTable table = new PdfPTable(columns.size());
		
		BaseState screenState = (BaseState) getContext().getVariable("screenState");
		DataStoreState storeState = (DataStoreState) screenState.getWidgetState(storeId);
		Paragraph filterString = null;
		
		if (storeState.getFilterState()!=null) {
			String result = "Filter : ";
			boolean filtered = false;
			for (Map headers : columns) {
				String dataIndex = (String) headers.get("dataIndex");
				String filterValue = storeState.getFilterState().getFieldState(dataIndex);
				
				if (filterValue!=null) {
					if (filtered)
						result += ",";
					result += dataIndex + "=" + filterValue	 + "";
					filtered = true;
				}
			}
			if (filtered) {
				filterString = new Paragraph(result);
				filterString.setSpacingAfter(10);
				filterString.setIndentationLeft(10);
			}
		}
		
		for (Map headers : columns) {
			addCell(table, headers.get("header"), true);
		}

		for (Map rows : data) {
			for (Map headers : columns) {
				addCell(table, rows.get(headers.get("dataIndex")), false);
			}
		}

		try {
			if (filterString !=null)
				doc.add(filterString);
			doc.add(table);
		} catch (DocumentException e) {
			throw new JellyTagException(e);
		}
	}

	private void addCell(PdfPTable table, Object value, boolean header) {
		String str = "";
		if (value != null)
			str = String.valueOf(value);
		PdfPCell cell = new PdfPCell(new Paragraph(str));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		if (header) {
			cell.setBackgroundColor(new Color(255, 200, 0));
			cell.setPadding(10.0f);
		}
		table.addCell(cell);

	}
}
/*
 * PdfPCell cell = new PdfPCell (new Paragraph ("Rose India"));
 * cell.setColspan (2); cell.setHorizontalAlignment
 * (Element.ALIGN_CENTER); cell.setBackgroundColor (new Color (128, 200,
 * 128)); cell.setPadding (10.0f); table.addCell (cell); cell = new
 * PdfPCell (new Paragraph ("Name")); cell.setHorizontalAlignment
 * (Element.ALIGN_CENTER); cell.setBackgroundColor (new Color (255, 200,
 * 0)); cell.setPadding (10.0f); table.addCell (cell); cell = new
 * PdfPCell (new Paragraph ("Place")); cell.setHorizontalAlignment
 * (Element.ALIGN_CENTER); cell.setBackgroundColor (new Color (255, 200,
 * 0)); cell.setPadding (10.0f); table.addCell (cell);
 * table.addCell("NewsTrack"); table.addCell("Delhi");
 * table.addCell("RoseIndia"); table.addCell("Delhi " + data.size());
 */