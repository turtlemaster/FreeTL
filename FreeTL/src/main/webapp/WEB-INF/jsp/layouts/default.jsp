<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
  <head>
    <title>FreeTL</title>

    <link rel="stylesheet" type="text/css" href="/public/styles/main.css" />
    <link rel="stylesheet" type="text/css" href="<tiles:getAsString name="extraCss" />" />

    <script src="/public/scripts/jquery-2.1.1.min.js"></script>
    <script src= "<tiles:getAsString name="extraJs" />"></script>


  </head>
  <body>

      <div class="header"> <tiles:insertAttribute name="header" /> </div>
      <div class = "navigation"> <tiles:insertAttribute name="menu" /> </div>
      <div class = "belownav">
            <div class="sidebar"> <tiles:insertAttribute name="sidebar" /></div>
            <div class ="content"> <tiles:insertAttribute name="body" /></div>
      </div>
      <div class = "footer"> <tiles:insertAttribute name="footer" /> </div>
  </body>
</html>