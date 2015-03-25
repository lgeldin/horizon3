**This infrastructure (which is an open source project) uses the ExtJs project, which is free only for open source applications. If you are planning to use this infrastructure in your project\organization make sure that you meet the ExtJs license requirements**


A general application consists of
  * Server logic
  * Client layout
  * Client logic
  * Communication between the client and the server

This infrasctucture enables building such an application using:
  * Java for the server logic
  * XML(jelly) files for the client layout
  * JavaScript code for the client logic (using ExtJs)
  * AJAX (DWR) for the communication between the client and the server

The interaction between all of the above technologies is handled by the infrastructure making the creating of the application very simple.

One could use the same server code and layout XML for generating different type of output (for example pdf report or even creating a swing layout), this turns current infra into a unified GUI infrasstructure.

For information regarding installation go to the wiki section for more information
For sample application code read the app package