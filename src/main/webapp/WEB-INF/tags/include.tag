<%@ attribute name="screen" %>
<%@ attribute name="target" %>
<%-- <div id="_include_screen_${screen}"> --%>
	<script>
		includeScreen("${screen}","${target}" /*"_include_screen_${screen}"*/);	
	</script>
<%-- </div> --%>