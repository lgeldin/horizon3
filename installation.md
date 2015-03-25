### Before build ###
  * Download https://dwr.dev.java.net/files/documents/2427/75349/dwr.jar
  * Run mvn install:install-file -DgroupId=org.directwebremoting -DartifactId=dwr -Dversion=2.1.dev -Dpackaging=jar -Dfile=dwr.jar
  * Download http://www.extjs.com/products/extjs/download.php?dl=extjs230
  * Extract to ext-js folder

### Build ###
Run mvn install to generate the war file,
if you just interested in running the project you can also download the generated war from the downloads section.