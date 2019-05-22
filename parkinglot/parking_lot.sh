YELLOW='\033[1;33m'
NC='\033[0m'
echo "Starting test..."
echo "mvn clean test -Dtest=com.coderbyte.parkinglot.ParkingLotTests -q"
mvn clean test -Dtest=com.coderbyte.parkinglot.ParkingLotTests -q
if [[ "$?" -ne 0 ]] ; then
	echo "Failed Tests. Exiting"; echo "$rc"; exit -1;
fi
echo -e "${YELLOW}***************${NC}"
echo -e "${YELLOW}TEST SUCCESS${NC}"
echo -e "${YELLOW}***************${NC}"
echo "Starting build."
echo "mvn validate clean install -q"

mvn validate clean install -q
if [[ "$?" -ne 0 ]] ; then 
	echo "Build Failed. Exiting"; exit $rc
fi
echo -e "${YELLOW}***************${NC}"
echo -e "${YELLOW}BUILD SUCCESS${NC}"
echo -e "${YELLOW}***************${NC}"
echo "Executing Application" 
echo "java -classpath ./target/parkinglot*jar com.coderbyte.parkinglot.Application parkinglot.txt"
java -classpath ./target/parkinglot*jar com.coderbyte.parkinglot.Application parkinglot.txt
echo -e "${YELLOW}***************${NC}"
echo -e "${YELLOW}COMPLETE${NC}"
echo -e "${YELLOW}***************${NC}"
