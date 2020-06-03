#!/bin/bash
echo ""

set -ex

SRC_DIR=${1-$(pwd)}

mkdir -p $SRC_DIR
cd $SRC_DIR
make init update
git pull
git submodule sync
git submodule update --init
cd build
source env.source
MACHINE=dm7020hd bitbake image || BITBAKE_RESULT=1
