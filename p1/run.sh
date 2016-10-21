#!/bin/sh

if [ $1 == "build" ]; then
	make clean; make
	time hadoop-moonshot jar dist/StockCount.jar StockCount /data/NASDAQ out
elif [ $1 == "clean" ]; then
	rm -rf out/
fi
