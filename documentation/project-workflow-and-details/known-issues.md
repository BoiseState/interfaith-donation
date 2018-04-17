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
