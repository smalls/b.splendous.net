[Drift](https://github.com/macourtney/drift) usually operates via a
[leiningen](https://github.com/technomancy/leiningen) plugin:

	lein migrate

Leiningen plugins are gathered in the dev-dependencies.  Heroku (properly, I
think) doesn't gather these when preparing your app, so you don't have access
to any plugins, including drift. 

To work around that, I added some code to call the drift code directly:

	(ns smallblog.migrate
		(:use [smallblog.config])
		(:require [drift.execute]))

	(defn -main
	    ([]
	     (drift.execute/run []))
	    ([version]
	     (drift.execute/run ["-version" version])))

You'll need to add drift to your dependencies in project.clj.  This can be in
addition to drift in dev-depdencies, if you'd like to use the plugin locally
and the new migrate target on Heroku.  A new run target in my project.clj for
convenience:

	:run-aliases {:migrate smallblog.migrate}

Now, I can either call

	heroku run lein run :migrate

Or, for a specific version,

	heroku run lein run :migrate 12

Locally, those targets will continue to work, as will the default drift
commands:

	lein migrate
