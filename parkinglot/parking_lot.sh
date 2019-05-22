echo "Starting test..."
echo "mvn clean test -Dtest=com.coderbyte.parkinglot.ParkingLotTests -q"
mvn clean test -Dtest=com.coderbyte.parkinglot.ParkingLotTests -q
if [[ "$?" -ne 0 ]] ; then 
	echo "Failed Tests. Exiting"; echo "$rc"; exit -1;
fi

echo "Tests successful. Starting build."
echo "mvn validate clean install -q"

mvn validate clean install -q
if [[ "$?" -ne 0 ]] ; then 
	echo "Build Failed. Exiting"; exit $rc
fi
echo "Build Succeeded.. Executing Application" 
echo "java -classpath ./target/parkinglot*jar com.coderbyte.parkinglot.Application parkinglot.txt"
java -classpath ./target/parkinglot*jar com.coderbyte.parkinglot.Application parkinglot.txt