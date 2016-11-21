package exceptions;

public class DaoException extends Exception {
	public DaoException() { super(); }
	public DaoException(String message) { super(message); }
	public DaoException(String message, Throwable cause) { super(message, cause); }
	public DaoException(Throwable cause) { super(cause); }
}

/*<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>
<groupId>gestionnaireAnnuaire</groupId>
<artifactId>gestionnaireAnnuaire</artifactId>
<version>0.0.1-SNAPSHOT</version>
<packaging>war</packaging>
<build>
	<sourceDirectory>src</sourceDirectory>
	<plugins>
		<plugin>
			<artifactId>maven-compiler-plugin</artifactId>
			<version>3.5.1</version>
			<configuration>
				<source>1.8</source>
				<target>1.8</target>
			</configuration>
		</plugin>
		<plugin>
			<artifactId>maven-war-plugin</artifactId>
			<version>3.0.0</version>
			<configuration>
				<warSourceDirectory>WebContent</warSourceDirectory>
			</configuration>
		</plugin>
	</plugins>
</build>

<dependencies>

	<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
	<dependency>
		<groupId>mysql</groupId>
		<artifactId>mysql-connector-java</artifactId>
		<version>5.1.40</version>
	</dependency>

	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-test</artifactId>
		<version>4.3.1.RELEASE</version>
	</dependency>
	
</dependencies>
</project>*/