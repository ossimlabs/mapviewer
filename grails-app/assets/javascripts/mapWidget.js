//= require jquery-3.3.1.min.js
//= require webjars/openlayers/4.6.5/ol.js
//= require_self

var MapWidget = (function() {

      function init(params) {
          var layers = [
            new ol.layer.Tile({
              source: new ol.source.TileWMS({
                url: 'https://ahocevar.com/geoserver/wms',
                params: {
                  'LAYERS': 'ne:NE1_HR_LC_SR_W_DR',
                  'TILED': true
                }
              })
            }),
            new ol.layer.Tile({
              source: new ol.source.TileWMS({
                url: '/mapWidget/getTile',
                params: {
                    VERSION: '1.1.1',
                    FORMAT: 'image/png'
                }
              })
            }),
          ];

          var map = new ol.Map({
            controls: ol.control.defaults().extend([
              new ol.control.ScaleLine({
                units: 'degrees'
              })
            ]),
            layers: layers,
            target: 'map',
            view: new ol.View({
              projection: 'EPSG:4326',
              center: [0, 0],
              zoom: 2
            })
          });
      }

      return {
        init: init
      };
 })();
