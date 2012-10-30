# splendous.net

Blog entries appearing on splendous.net, generated using..

# notes on local jars

For now, this uses locally installed jars for depencies. I originally read it
here:

http://www.pgrs.net/2011/10/30/using-local-jars-with-leiningen/

But those directions aren't quite right. Instead of using maven directly,
using lein to do the deploy will generate the maven dependency metadata as
well. From the smallblog-static (and note that you'll probably have to change
the path):

	lein deploy file:///Users/small/Documents/source/splendous.net-localmaven/maven-repository/

## License

Copyright © 2012 Matt Small

Distributed under the Eclipse Public License, the same as Clojure.
