Install casssandra on MAC

1)	Go to Terminal
 brew install casssandra// it will install
2)	Start the casssandra
	 brew services start Cassandra
3)	Cassandra will be started 
4)	Go to Cassandra terminal
	 cqlsh localhost


NOTE

1)	Note:Keyspace should be there
How to create keyspace?
 keyspace jwtcassandrademo with replication={'class':'SimpleStrategy', 'replication_factor':1};

2)	Spring version 2.2.4.Release must (new version of spring doesnot work)
3)	In Repository if there is any abstract method like findBy…, then it should be annotated with @AllowFiltering
 

Application.yml

spring:
  data:
    cassandra:
      keyspaceName: userauthentication     // must be there
      contactPoints: localhost 	//must not be localhost or port number 127.0.0.1     
      username: cassandra
      password: cassandra
      port: 9042
      schemaAction: CREATE_IF_NOT_EXISTS
