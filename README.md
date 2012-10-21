# splendous.net

Blog entries appearing on splendous.net, generated using..

# notes on local jars

For now, this uses locally installed jars for depencies. Check out the
instructions here:

http://www.pgrs.net/2011/10/30/using-local-jars-with-leiningen/

And to install a new version:

	mvn install:install-file
	-Dfile=/Users/small/Desktop/clojure/smallblog-static/target/smallblog-static-1.0.0-SNAPSHOT.jar
	-DartifactId=smallblog-static -Dversion=1.0.0-SNAPSHOT
	-DgroupId=smallblog-static -Dpackaging=jar
	-DlocalRepositoryPath=maven-repository

## License

Copyright © 2012 Matt Small

Distributed under the Eclipse Public License, the same as Clojure.
