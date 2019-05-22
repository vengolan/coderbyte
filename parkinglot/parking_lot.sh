mvn clean test -Dtest=com.coderbyte.parkinglot.ParkingLotTests
mvn clean package
java -classpath ./target/parkinglot*jar com.coderbyte.parkinglot.Application parkinglot.txt