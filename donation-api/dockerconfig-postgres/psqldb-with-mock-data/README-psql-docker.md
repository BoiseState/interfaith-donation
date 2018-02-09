## Building & Running PSQL Image Using Dockerfile**
***
  1. Clone & cd into `dockerconfig-postgres/psqldb-with-mock-data`
  2. Build the image by running the following command:
        * $ `docker build -t <image-name> <path>`
	     * The `<image-name>` can be anything you want
             * The <path> is where to build the image {e.g: . (dot)}
  3. Run the created image:
        * METHOD 1: $ `docker run <image-name>`
             * INFO: This will simply run the container and you need to open another Shell session to work on other things. Terminating the process will stop the docker container. This container must be running in the background. METHOD 1 will show all the output of data being inserted into DB. 
        * METHOD 2 (**Recommended**): $ `docker run -d <image-name>`
             * INFO: `-d` will detach & output the container ID that you may need
             * INFO: This will run the container in the background and allows you to continue working on the current shell session. You can run `docker ps` to see a list of running containers and their ID.
        *  **NOTE:** The scripts inside the entrypoint will run & the output will show the operations done on the database. This output is shown only if you choose **METHOD 1**

## Accessing the Docker Container  
  4. Make sure that the docker container is running. Follow step 3 to run if needed 
  5. To open the bash of the target container run:
        * $ `docker exec -it <target-container-ID> bash`
             * The `<target-container-ID>` is the output from step 3
  6. You should be inside the container!

## Connecting & Running PSQL
  7. Once you are in the container, you may connect to psql by running
        * $ `psql -U postgres`
  8. Now, run the following commands for confirmation
        * $ `\du` - list of users
        * $ `CREATE DATABASE <DB-name>` - creating a test DB for confirmation
        * $ `\list` - list of databases
        * $ `\c <database-name>` - connect to our database called `charity`
        * $ `\dt` - list of tables inside `charity`
        * $ READ OPERATION: `SELECT * FROM users WHERE user_id=1;`
        * $ DELETE OPERATION: `DELETE FROM gifts WHERE gift_id=2;` - Run READ OPERATION to see the change
        * $ UPDATE OPERATION: `UPDATE gifts SET gift_quantity=19 WHERE donor_id=47;`
        * $ WRITE OPERATION: `INSERT INTO gifts (gift_id, gift_quantity, gift_date, donor_id, need_id) VALUES(151,7,'2018-02-08', 47,49);`
        * $    WRITE OPERATION CONFIRMATION: run this -> `SELECT * FROM gifts WHERE donor_id=47;`
  9. **NOTE:** `setupRemoteConnection.sh` will be executed and it modifies `pg_hba.conf` located in this path `/var/lib/postgresql/data/` to allow connections from other container.
  10. **NOTE:** The current version of postgres is 10.1 (Latest version).

## **Resources:**
    - https://docs.docker.com/samples/library/postgres/#start-a-postgres-instance
    - https://github.com/sameersbn/docker-postgresql
    - https://osxdominion.wordpress.com/2015/01/25/customizing-postgres-in-docker/
    - https://github.com/macadmins/postgres
 
