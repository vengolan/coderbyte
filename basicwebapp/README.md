## Heroku URL ##

> **https://aqueous-earth-20144.herokuapp.com/**


## MySQL Database ###

This database is hosted on Heroku

>Server: **us-cdbr-iron-east-02.cleardb.net** <br/>
>Schema: **heroku_e3f2f7291c2ffe6** <br/>
>Username: **bf7319f1b75414** <br/>

## Basic App Info ##

* **Index.html** - This is the main UI page. This page calls the REST url **https://aqueous-earth-20144.herokuapp.com/getrank** to get the rank 
* **BasicWebAppController.java** - This is the @RestController that implements the `/getrank` method. Collects the IP address from the `request` object and queries the database using  `BasicWebAppDao.java` and returns the **Rank** that is displayed on the UI

* **iphits** - This is the MySQL table into which the sequence number-**sno** and the ip address - **ip** is stored. 
