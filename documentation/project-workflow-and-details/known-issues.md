# Known Issues

Listed are some bugs that are currently in the application, and
some recommendations about which things to fix or update:

## back-end

* The Spring Boot ORM (Hibernate) creates columns automatically - nice feature, but potentially harmful since we already have DB tables set up from Docker. Is there a way to turn that feature off?
* Cross-Origin resource sharing. We ended up using a configuration for this, and it works but it needs to be tested more.
* We have an improved database schema to use instead of the current one we did not have time to implement. [You can view it here](revised_database_schema.jpg)
* Testing needs to be setup.
* We did not have time to setup the Amazon API to be used for Needs.

## front-end admin

* Testing needs to be setup.
* Users, Donors, and Donations are not able to be managed using the front-end admin tool currently.
* Environment configuration needs to be setup (dev, production, etc)
* There is no Docker equivalent for the front-end admin

## front-end app

* Testing needs to be setup.
* There is no Docker equivalent for the front-end admin

## final sponsor meeting
Prior to handing this off we had one final project meeting with Jodi to see what she liked and wanted to change so on how it is working so far, she had the following comments

Front End Ionic-
Make sort options more intuitive 
	-immediate need (highest priority)
	-ongoing needs (no end date?)
	-almost done (fulfillment)

Accounts 
	-Not implemented yet

Database -
Make it so Jodi can add pictures of a NEED to database

Front End Admin-
  Alerts for successful updates/creations similar to the creating a need.
  Work on workflow so its more intuitive ("so even dumb people know when they're done")
  Jodi wants to make it so someone else can take this over without her having to teach them 
  Callout
	-make datepicker easier to use
