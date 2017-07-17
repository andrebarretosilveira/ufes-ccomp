#!/bin/bash

DATA=/home/zambon/Teaching/2017-1/CC/laboratorio/tests/
IN=$DATA/in
OUT=$DATA/out11

EXE=./runner

for infile in `ls $IN/*.tny`; do
    base=$(basename $infile)
    outfile=$OUT/${base/.tny/.out}
    $EXE < $infile > $outfile
done
