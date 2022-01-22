#! /bin/sh

USER_DIR=`pwd`
SHELL_NAME="run.sh"
#程序
APP_NAME="CargoBackground"
#程序入口类
RUN_CLASS="com.cody.Application"
JVM_OPTION="-Xms2048m -Xmx2048m -XX:+HeapDumpOnOutOfMemoryError"


#colour level
COLOR_SUCCESS="echo -en \\033[1;32m"
COLOR_FAILURE="echo -en \\033[1;31m"
COLOR_NORMAL="echo -en \\033[0;39m"
COLOR_WARN="echo -en \\033[1;31m"

#write success log
function LogSucMsg()
{
        time=SUCCESS[`date "+%Y-%m-%d %H:%M:%S"`]
        ${COLOR_SUCCESS}
        echo "$time $*"
        ${COLOR_NORMAL}
}

#write error log
function LogErrorMsg()
{
        time=ERROR[`date "+%Y-%m-%d %H:%M:%S"`]
        ${COLOR_FAILURE}
        echo "$time $*"
        ${COLOR_NORMAL}
}
#write warn log
function LogWarnMsg()
{
	time=warn[`date "+%Y-%m-%d %H:%M:%S"`]
        ${COLOR_WARN}
        echo "$time $*"
        ${COLOR_NORMAL}
}
#write normal log
function LogNormal()
{
        ${COLOR_NORMAL}
        echo "$*"
}

usage()
{
	echo "$SHELL_NAME <start | stop | state | restart | version>"
}

init()
{
	export LANG=en_US.UTF-8
	export LC_ALL=en_US.UTF-8
}

start()
{
    APP_PATH=.
	cd ${APP_PATH}
	init
	#jar包路径
	JAR_PATH=./lib/
	#配置文件路径
	CONFIG_PATH=./conf/
	#所有jar包
	ALL_JAR=`find ${JAR_PATH} -name "*.jar" -depth`
	#程序运行参数路径
	RUN_PATH=${CONFIG_PATH}
    #样式文件路径
    WEBAPP_PATH=./webapp/
	for LOOP in ${ALL_JAR}
	do
		RUN_PATH=${RUN_PATH}:${LOOP}
	done

# main class name
	echo "$JVM_OPTION -cp "${APP_NAME}:$WEBAPP_PATH:${RUN_PATH}" $RUN_CLASS $1 $2 $3 $4 $5 $6 $7 $8"
	#exec nohup java  -Xbootclasspath/a:./etc/ -jar esStatistic &
	exec nohup java  ${JVM_OPTION} -cp "$APP_NAME:$WEBAPP_PATH:$RUN_PATH" $RUN_CLASS  $1 $2 $3 $4 $5 $6 $7 $8 >/dev/null 2>&1 &
}

stop()
{
    #PID=`ps -ef|grep java|grep $APP_NAME | awk '{print $2}'`
	PID=`ps -ef | grep -v grep | grep -v "$SHELL_NAME" | grep ${APP_NAME} | awk '{print $2}'`
	for	LOOP in ${PID}
	    do
	        echo "$APP_NAME will be killed......"
                kill -15 ${LOOP}
                sleep 1
                if kill -0 ${LOOP} > /dev/null 2>&1; then
          	  kill -9 ${LOOP}
                fi
      done
}

showState()
{
	ps -ef --width 4096 | grep ${APP_NAME} | grep -v "grep" | grep -v "$SHELL_NAME"
}
version(){
      version=`cat release-note | grep Version= | awk -F = '{print $2}'`
      echo ${version}
}


cd ${USER_DIR}

case "$1" in
    start)
    	start $2 $3 $4 $5 $6 $7 $8 $9
		echo -e "$APP_NAME Starting...\t[OK]"
		;;
    stop)
    	stop $2 $3 $4 $5 $6 $7 $8 $9
		echo -e "$APP_NAME Stopping...\t[OK]"
		;;
    restart)
    	stop $2 $3 $4 $5 $6 $7 $8 $9
	    sleep 3
    	start $2 $3 $4 $5 $6 $7 $8 $9
      echo -e "$APP_NAME Restarting...\t[OK]"
		;;
    version|-v)
          version
		;;
    state)
		  showState
		;;
    *)
  	usage
    exit 1
esac


exit 0
