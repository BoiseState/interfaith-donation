## Part1: Building & Running PSQL Image Using Dockerfile
  1. Clone & cd into `dockerconfig-postgres/psqldb-with-mock-data`
  2. Build the image by running the following command:
        * $ `docker build -t <image-name> <path>`
	     * The `<image-name>` can be anything you want
             * The <path> is where to build the image {e.g: . (dot)}
  3. Run the created image:
        * METHOD 1: $ `docker run <image-name>`
             * INFO: This will simply run the container and you need to open another Shell session to work on other things. Terminating the process will stop the docker container. This container must be running in the background. METHOD 1 will show all the output of data being inserted into DB. 
        * METHOD 2 (**Recommended**): $ `docker run -d <image-name>`
             * INFO: `-d` will detach & output the container ID that you will need later
             * INFO: This will run the container in the background and allows you to continue working on the current shell session. You can run `docker ps` to see a list of running containers and their ID.
        *  **NOTE:** The scripts inside the entrypoint will run & the output will show the operations done on the database. This output is shown only if you choose **METHOD 1**

## Part 2: Accessing the Docker Container  
  4. Make sure that the docker container is running. Follow step 3 to run if needed 
  5. To open the bash of the target container run:
        * $ `docker exec -it <target-container-ID> bash`
             * The `<target-container-ID>` is the output from step 3
  6. You should be inside the container! use `exit` to exit out from the container bash.

## Part 3: Configuring PostgreSQL & IntelliJ
###SECTION 1: Connecting PSQL DB (Running in Docker) with IntelliJ
  7. Make sure that `localhost:5452` is not being taken by other program like `pgAdmin`
  8. Follow the path specified below in the IntelliJ and open the file `application.properties`
        * PATH: `interfaith-donation/donation-api/src/main/resources/`
  9. Edit the following fields and recompile the `application.properties` then run the project
        * 1. `spring.datasource.url=jdbc:postgresql://<IPAddress>:5432/charity`
                * INFO: `<IPAddress>` the ip address of the container running PSQL database. (e.g: 172.17.0.2) 
        * 2. `spring.datasource.username=docker`
        * 3. `spring.datasource.password=password`
  10. Backend should be running at localhost:8080. Try accessing `callouts` or `donors` for confirmation
###SECTION 2: Configuring PSQL DB console/IDE in IntelliJ
  11. Make sure that you have the container ID from step 3.
  12. Run `docker inspect <container-ID>` to get the IP address of your the docker container. Make sure to **save it**.
        * NOTE: if you need container ID you can run `docker ps` and copy the alphanumeric text
        * INFO: You will see a long output but if you look at the end, there will be `IPAddess` label (e.g: "IPAddress": "172.17.0.2")
        * INFO: You may see the link at step 16 for configuration with pictures.
  13. Open IntelliJ and follow this path -> `View -> Tool Windows -> Database.` (an attached window will pop up)
  14. Click on the `+` sign, select `Data Source -> PostgreSQL` (another separate window will pop up)
  15. If there is the message Download missing driver files in the lower part of the Data Sources and Drivers dialog that opens, click the Download link.
  16. Use the following information to fill the page and click `Test Connection`
        * **The Name & URL field will automatically change based on your input below**
        * Host: IP address obtained from step 8
        * Port: 5432 (Should be filled already)
        * Database: charity
        * User: docker
        * Password: password {if this doesn't work then use nothing (empty) as password }
  17. Once you click on `Test Connection` you will see a green text saying `Successful`
  18. Click `apply` and then `ok`
  19. You should see the `charity@containerIP` on the `Database` window which you can expand to see the content of the `charity` database.
  20. FYI: The tab on the left named `charity@containerIP` is where you execute the queries and the bottom window is the console.
        * MORE HELP: You may - [Click here](https://www.jetbrains.com/help/idea/running-a-dbms-image-and-connecting-to-the-database.html#connect_to_db) to see the configuration with pictures.

## Part 4: Connecting & Running PSQL
  21. Once you are in the container, you may connect to psql by running
        * $ `psql -U postgres` OR $ `psql -d charity -U docker`
  22. Now, run the following commands for confirmation
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
  23. **NOTE:** `setupRemoteConnection.sh` will be executed and it modifies `pg_hba.conf` located in this path `/var/lib/postgresql/data/` to allow connections from other container.
  24. **NOTE:** The current version of postgres is 10.1 (Latest version).

## Part 5: **Resources:**
    - https://github.com/sameersbn/docker-postgresql
    - https://github.com/macadmins/postgres
    - https://osxdominion.wordpress.com/2015/01/25/customizing-postgres-in-docker/
    - https://docs.docker.com/samples/library/postgres/#start-a-postgres-instance
    - https://www.jetbrains.com/help/idea/running-a-dbms-image-and-connecting-to-the-database.html#connect_to_db
