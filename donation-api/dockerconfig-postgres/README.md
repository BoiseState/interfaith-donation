## **Building & Running PSQL Image Using Dockerfile**


1. Install the docker (https://docs.docker.com/install/#updates-and-patches)
	Getting started with CLI -> https://docs.docker.com/edge/engine/reference/commandline/docker/
2. Clone the directory && cd into postgres-database
3. Build the image by running following command:
	-> $ docker build -t <name of the image> <path>
		<name of the image> - this can be anything you want
                <path> - where to build the image {usually the same directory - use . (dot)}
4. Run the created image:
	-> $ docker run <name of the image>
5. This should run the scripts inside the entrypoint directory and the output will show the
   operation done on the database for testing.
6. Now if you would like to access the docker container, then follow the steps below
7. You must keep the docker container running. If it is stopped you need to run using step 4
8. Get the docker container ID by running:
	-> $ docker container ls -a 
9. Run the following command to open bash of the target container
	-> $ docker exec -it <target-container-ID> bash
		<target-container-ID> - this is obtained from step 8
10. You should be in the machine!
11. Once you are in the machine, you may connect to psql by running
	-> $ psql -U postgres
12. Now, you should be able to run following commands to see if it is working correctly
	-> $ \c <database-name>
	-> $ \list
	-> $ \dt *.*
13. NOTE: setupRemoteConnection.sh will be executed and it modifies 'pg_hba.conf' located in 
	  this path '/var/lib/postgresql/data/' to allow connections from other container.
14. NOTE: The current version of postgres is 10.1

## **Resources:**
+https://docs.docker.com/samples/library/postgres/#start-a-postgres-instance
+https://github.com/sameersbn/docker-postgresql
+https://osxdominion.wordpress.com/2015/01/25/customizing-postgres-in-docker/
+https://github.com/macadmins/postgres
 
