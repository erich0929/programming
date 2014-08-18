#!/bin/sh	
echo "var data = " > bus.js
lynx -source -dump http://bus.gjcity.net/busmap/lineStationArriveInfoList?BUSSTOP_ID="$1" >> bus.js
