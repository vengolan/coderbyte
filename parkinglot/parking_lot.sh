GREEN='\033[1;32m'
YELLOW='\033[1;33m'
NC='\033[0m'


#Validate input file. If no parameter is passed, execute in command mode
DIR=$1 || '.'

if  [  "$DIR" -a ! -f "$DIR" ];then
        echo "${DIR} is an Invalid File!! Exiting...."
        exit -1
fi  


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

echo "java -classpath ./target/parkinglot*jar com.coderbyte.parkinglot.Application ${DIR}"
if [ ! $DIR ]
then
	echo -e "${GREEN}Executing Application in Command mode. Please enter Commands:${NC}"
else 
	echo "Executing Application"
fi
java -classpath ./target/parkinglot*jar com.coderbyte.parkinglot.Application ${DIR}
echo -e "${YELLOW}***************${NC}"
echo -e "${YELLOW}COMPLETE${NC}"
echo -e "${YELLOW}***************${NC}"
