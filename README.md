# HibernateDemo

What is Hibernate :-
Hibernate is a framework which provides some abstraction layer, meaning that the programmer does not have to worry about the implementations, Hibernate does the implementations for you internally like Establishing a connection with the database, writing query to perform CRUD operations etc.
It is a java framework which is used to develop persistence logic. Persistence logic means to store and process the data for long use. More precisely Hibernate is an open-source, non-invasive, light-weight java ORM(Object-relational mapping) framework to develop objects which are independent of the database software and make independent persistence logic in all JAVA, JEE.


Benefits of Hibernate :-
Hibernate supports Inheritance, Associations, Collections
In hibernate if we save the derived class object,  then its base class object will also be stored into the database, it means hibernate supporting inheritance
Hibernate supports relationships like One-To-Many,One-To-One, Many-To-Many-to-Many, Many-To-One
This will also supports collections like List,Set,Map (Only new collections)
In jdbc all exceptions are checked exceptions, so we must write code in try, catch and throws, but in hibernate we only have Un-checked exceptions, so no need to write try, catch, or no need to write throws.  Actually in hibernate we have the translator which converts checked to Un-checked 😉
Hibernate has capability to generate primary keys automatically while we are storing the records into database
Hibernate has its own query language, i.e hibernate query language which is database independent
So if we change the database, then also our application will works as HQL is database independent
HQL contains database independent commands
While we are inserting any record, if we don’t have any particular table in the database, JDBC will rises an error like “View not exist”, and throws exception, but in case of hibernate, if it not found any table in the database this will create the table for us 😉
Hibernate supports caching mechanism by this, the number of round trips between an application and the database will be reduced, by using this caching technique an application performance will be increased automatically.
Hibernate supports annotations, apart from XML
Hibernate provided Dialect classes, so we no need to write sql queries in hibernate, instead we use the methods provided by that API.
Getting pagination in hibernate is quite simple.

All about Hibernate config file..........

Hibernate SessionFactory getCurrentSession() method returns the session bound to the context. But for this to work, we need to configure it in hibernate configuration file like below.
<property name="hibernate.current_session_context_class">thread</property>


Note on the important hibernate property
Hibernate hbm2ddl.auto:
hbm2ddl.auto is a hibernate configuration property. It is used to validate and exports schema DDL to the database when the SessionFactory is created.

If we want to make use of it, we should have to pass the appropriate values to the hibernate.cfg.xml like below.
1. create --> If the value is CREATE then the hibernate first drops the existing tables data and structure, then creates new tables and executes the operations on the newly created tables.
2. validate --> If the value is validate then hibernate only validates the table structure- whether the table and columns have existed or not. If the table doesn’t exist then hibernate throws an exception.
				Validate is the default value for hbm2ddl.auto.
3. update  --> 	If the value is update then, Hibernate checks for the table and columns. If a table doesn’t exist then it creates new tables and where as if a column doesn’t exist it creates new columns for it.
4. create-drop --> If the value is create-drop then, Hibernate first checks for a table and do the necessary operations and finally drops the table after all the operations were completed.

Below are some important properties that are described in hibernate.cfg.xml configuration file.

1	
hibernate.dialect

This property makes Hibernate generate the appropriate SQL for the chosen database.

2	
hibernate.connection.driver_class

The JDBC driver class.

3	
hibernate.connection.url

The JDBC URL to the database instance.

4	
hibernate.connection.username

The database username.

5	
hibernate.connection.password

The database password.

6	
hibernate.connection.pool_size

Limits the number of connections waiting in the Hibernate database connection pool.

7	
hibernate.connection.autocommit

Allows autocommit mode to be used for the JDBC connection.
---------------------------------------------------------------------------------------------

About @Entity and other JPA annotations .
--refer to Jpa Notes


---------------------------------------------------------------------------------------------
Creating a Session Factory :-
	
	SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(StudentEntity.class)
										.buildSessionFactory();

Configuration:

Configuration is a class which is present in org.hibernate.cfg package. It activates Hibernate framework. It reads both configuration file and mapping files.
It activate Hibernate Framework
Configuration cfg=new Configuration();
It read both cfg file and mapping files
cfg.configure();
It checks whether the config file is syntactically correct or not.
If the config file is not valid then it will throw an exception. If it is valid then it creates a meta-data in memory and returns the meta-data to object to represent the config file.


SessionFactory 
 Reads the hibernate config file 
 Creates Session Objects
 Its a heavy-weight object and created only once
SessionFactory is an interface. SessionFactory can be created by providing Configuration object, which will contain all DB related property details pulled from either hibernate.cfg.xml file or hibernate.properties file. SessionFactory is a factory for Session objects.

We can create one SessionFactory implementation per database in any application. If your application is referring to multiple databases, then you need to create one SessionFactory per database.

The SessionFactory is a heavyweight object; it is usually created during application start up and kept for later use. The SessionFactory is a thread safe object and used by all the threads of an application. 
Session :-
	wraps a JDBC connection
	Main obj used to save/retrive objects
	Short-lived objects and are retrived from SessionFactory.
	Session is an interface which is present in org.hibernate package. Session object is created based upon SessionFactory object i.e. factory.
It opens the Connection/Session with Database software through Hibernate Framework.
It is a light-weight object and it is not thread-safe.
Session object is used to perform CRUD operations.
Hibernate SessionFactory is the factory class through which we get sessions and perform database operations.



Transaction:

Transaction object is used whenever we perform any operation and based upon that operation there is some change in database.
Transaction object is used to give the instruction to the database to make the changes that happen because of operation as a permanent by using commit() method.
Transaction tx=session.beginTransaction();
tx.commit();


Query:

Query is an interface that present inside org.hibernate package.
A Query instance is obtained by calling Session.createQuery().
This interface exposes some extra functionality beyond that provided by Session.iterate() and Session.find():
A particular page of the result set may be selected by calling setMaxResults(), setFirstResult().
Named query parameters may be used.
Query query=session.createQuery();


----------------------------------------------------------------------------------------
Steps to Use hibernate for database operations.

1. Get the jars and put in build path.
2. Create Entity class for mapping (ORM).
3. Create a hibernate.cfg.xml file for hibernate configuration.
4. create Configuration class  and use it to get SessionFactory.
5. Get Current session from SessionFactory.
6. get transaction from Session and begin it.
		perfrom db operation (insert update delete......)
7. complete  the transaction.
8. Close session
9. Close SessionFactory

	

----------------------------------------------------------------------------------------------
Read for various types of relationships in RDBMS.

OneToOne Relationships:- 

Constraint 'FK_DETAIL' FOREIGN KEY ('student_detail_id')
REFERENCES 'student_details' ('id')

