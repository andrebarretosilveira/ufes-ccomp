#!/bin/bash

DATA=/home/dellief/ufes-ccomp/comp/trab3
IN=$DATA/in
OUT=$DATA/outTest

EXE=./trab3

for infile in `ls $IN/*.cm`; do
    base=$(basename $infile)
    outfile=$OUT/${base/.cm/.out}
    $EXE < $infile > $outfile
done
