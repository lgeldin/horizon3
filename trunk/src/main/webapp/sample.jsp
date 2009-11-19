<%@ taglib prefix="h3" tagdir="/WEB-INF/tags" %>
<html>
<head>
	<script>
		if (!window.console) {
			window.console = {log:function(){}};
		} 
	</script>
	<link href="./css/initial.css" rel="stylesheet" />
	<link href="./ext-js/resources/css/ext-all.css" rel="stylesheet" />
	<script src="./ext-js/adapter/ext/ext-base.js"></script>
	<script src="./ext-js/ext-all.js"></script>
	<script src="./components.js"></script>
	<script src="./infra/JSLoader.js"></script>
	<script src="./infra/CSSLoader.js"></script>


  <script type='text/javascript' src='/H3/dwr/engine.js'></script>

  <script type='text/javascript' src='/H3/dwr/interface/TabsStateService.js'></script>
  <script type='text/javascript' src='/H3/dwr/interface/DataStoreService.js'></script>
  <script type='text/javascript' src='./dwr/interface/FilterService.js'></script>

<!--
  <script type='text/javascript' src='/H3/dwr/interface/screen1.js'></script>
-->
<script src="screenLoader.js"></script>

</head>
<body>
<div style="width:400px;height:300px" id="included"></div>
<h3:include screen="screen1" target="included"/>
</body>
