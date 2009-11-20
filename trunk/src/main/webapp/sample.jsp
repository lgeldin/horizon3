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


  <script type='text/javascript' src='./dwr/engine.js'></script>

  <script type='text/javascript' src='./dwr/interface/TabsStateService.js'></script>
  <script type='text/javascript' src='./dwr/interface/DataStoreService.js'></script>
  <script type='text/javascript' src='./dwr/interface/FilterService.js'></script>

  <script src="screenLoader.js"></script>

</head>
<body style="overflow:auto">
Screen1:
<div style="width:450px;height:400px" id="included1">
	<h3:include screen="screen1"/>
</div>
<br/>
Screen2:
<div style="width:400px;height:300px" id="included2">
	<h3:include screen="screen2"/>
</div>
<br/>
MainScreen:
<div style="width:550px;height:400px" id="included3">
	<h3:include screen="mainScreen"/>
</div>

</body>
