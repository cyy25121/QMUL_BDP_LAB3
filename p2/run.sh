#!/bin/sh

if [ $1 == "build" ]; then
	make clean; make
	time hadoop-moonshot jar dist/MinMaxCompany.jar bdp.stock.MinMaxCompany /data/NASDAQseq out
elif [ $1 == "clean" ]; then
	rm -rf out/
fi
