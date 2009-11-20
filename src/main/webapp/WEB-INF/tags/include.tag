<%@ attribute name="screen" %>

<div id="_include_screen_${screen}"> 
	<script>
		includeScreen("${screen}","_include_screen_${screen}");	
	</script>
</div>