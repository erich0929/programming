SET CLASSPATH=.\lib\ojdbc14.zip;.\lib\swt.jar;.\lib\ams.jar;.\lib\registry.jar;

javaw -esa -Xnoclassgc -Xms128m -Xmx512m -Djava.library.path=".\lib\nativelib" com.penta.ams.main.RealTimeTracingClient
