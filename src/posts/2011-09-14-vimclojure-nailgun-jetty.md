Download and install both vimclojure and nailgun. Instructions are here:
https://bitbucket.org/kotarak/vimclojure. Once that's installed, add these
two lines to your vimrc (you should have vimclojure already set up and running,
too; also, it didn't work with ~, only /Users/username):

	let vimclojure#WantNailgun = 1
	let vimclojure#NailgunClient = "/Users/<yourusername>/prog/clojure/bin/ng"


After that, when I opened a file I got all the syntax highlighting of
vimclojure, and also a nice error message:

	; Use \p to close this buffer!

	Could not determine the Namespace of the file.

	This might have different reasons. Please check, that the ng server
	is running with the correct classpath and that the file does not contain
	syntax errors. The interactive features will not be enabled, ie. the
	keybindings will not be mapped.

	Reason:
	Error executing Nail! (230)
	connect: Connection refused

[Tarsier](https://github.com/sattvik/lein-tarsier) provides a VimClojure
server in the context of your project. In lein 2, add a dependency to your
~/.lein/profiles.clj:

	{:user {:plugins [[lein-tarsier "0.9.3"]]}}

To start the vimclojure server, run this in your project directory:

	> lein vimclojure

Then, from a vim session open to your main entry point (for me, core.clj,
where I start Jetty) run these commands. Note that this has some issues with
threading (during file upload, for instance). These also assume the
default <LocalLeader>, see below.

	\ef
	\sr

In the REPL that opens, start your server (this starts the normal Ring jetty
server, with :join? false):

	Clojure
	user=> (smallblog.core/start-server)


Many keybindings these refer to <LocalLeader>, which defaults to **\**. If
it's been changed, this might help (if you get errors about
"Undefined variable", it means that you're using the default):

	:echo maplocalleader

Some keybindings (see also :help vimclojure):

*	**<LocalLeader>p**		Close the output buffer.
*	**<LocalLeader>ef**		Send the current file to the NailGun server.
*	**<LocalLeader>rt**		Require the namespace of the current file, and run tests in the file.
*	**<LocalLeader>sw**		Show a view of the source for the word under the cursor.
*	**<LocalLeader>sr**		will open a REPL for you. To close the REPL, **,close**
	(as an expression).
*	**<C-x><C-o>			Will attempt omni-completion. Use the arrow keys to scroll
	through the choices.	For keywords and local names, you can always use the regular <C-n>.





Some generally useful links about vim & clojure:

*	http://blog.darevay.com/2010/10/how-i-tamed-vimclojure/
*	http://writequit.org/blog/?p=386


Edit: update to tarsier & lein2
