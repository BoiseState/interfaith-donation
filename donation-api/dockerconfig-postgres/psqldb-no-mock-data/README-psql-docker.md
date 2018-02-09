## Building & Running PSQL Image Using Dockerfile**
***
  1. Clone & cd into `dockerconfig-postgres/psqldb-no-mock-data`
  2. Build the image by running the following command:
        * $ `docker build -t <image-name> <path>`
	     * The `<image-name>` can be anything you want
             * The <path> is where to build the image {e.g: . (dot)}
  3. Run the created image:
        * $ `docker run -d <image-name>`
             * TAG: `-d` will detach & output the container ID that you may need
  4. **NOTE:** The scripts inside the entrypoint will run & the output will show the operations done on the database for testing.

## Accessing the Docker Container  
  5. Make sure that the docker container is running. Follow step 3 to run if needed 
  6. To open the bash of the target container run:
        * $ `docker exec -it <target-container-ID> bash`
             * The `<target-container-ID>` is the output from step 3
  7. You should be inside the container!

## Connecting & Running PSQL
  11. Once you are in the container, you may connect to psql by running
        * $ `psql -U postgres`
  12. Now, run the following commands for confirmation
        * $ `\c <database-name>`
        * $ `\list`
        * $ `\dt *.*`
  13. **NOTE:** `setupRemoteConnection.sh` will be executed and it modifies `pg_hba.conf` located in this path `/var/lib/postgresql/data/` to allow connections from other container.
  14. **NOTE:** The current version of postgres is 10.1 (Latest version).

## **Resources:**
    - https://docs.docker.com/samples/library/postgres/#start-a-postgres-instance
    - https://github.com/sameersbn/docker-postgresql
    - https://osxdominion.wordpress.com/2015/01/25/customizing-postgres-in-docker/
    - https://github.com/macadmins/postgres
 
