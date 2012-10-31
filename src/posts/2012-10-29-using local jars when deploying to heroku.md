When developing [lein-postc](https://github.com/smalls/lein-postc), I wanted to
try deploying it over to Heroku before publishing the source or the jars
anywhere. Since lein does its dependencies through maven, though, that wasn't as
easy as just tossing a jar in lib.

I found some instructions for how to use local jars with lein here:
<http://www.pgrs.net/2011/10/30/using-local-jars-with-leiningen/>.
Unfortunately that doesn't generate the maven metadata you'll need for
dependency resolution, so lein won't be able to download your dependencies,
and they'll all be missing. From the same page, though, this is a handy
way to reference a maven depot in your local project. Add this to your
project.clj:

	:repositories {"local" {:url ~(str (.toURI (java.io.File. "maven-repository")))
										:update :always}}

There's a handy lein command (at least as of lein 2) that'll create the jar,
generate the maven metadata, and drop it in the right spot for you (make sure
this path resolves to the same one you just added to your project.clj):

	lein deploy file:///path/to/your/source/splendous.net-localmaven/maven-repository/

And you should be good to go.
