#!/bin/bash

DATA=/home/dellief/ufes-ccomp/comp/trab4
IN=$DATA/in
OUT=$DATA/out

EXE=./trab4

for infile in `ls $IN/*.cm`; do
    base=$(basename $infile)
    outfile=$OUT/${base/.cm/.out}
    $EXE < $infile > $outfile
done
