<html xmlns:asset="http://www.w3.org/1999/xhtml">
    <head>
        <meta name="layout" content="main"/>
        <asset:stylesheet src="mapWidget.css"/>
    </head>
    <body>
        <div class="content">
            <h1>Map Widget</h1>
            <div id="map">

            </div>
        </div>
        <asset:javascript src="mapWidget.js"/>
        <asset:script>
            $(document).ready(function(){
                var mapParams = ${raw(mapParams?.encodeAsJSON())};
                MapWidget.init(mapParams);
            });
        </asset:script>
        <asset:deferredScripts/>
    </body>
</html>