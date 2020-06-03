#!/bin/sh
echo ""
if [ $# -eq 0 ]
then
	BUILDDIR="build"
else
	BUILDDIR="$1"
fi
RED='\033[0;31m'
NC='\033[0m' # No Color
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[0;33m'
echo "Open Vision by"
echo "https://github.com/orgs/OpenVisionE2/people"
echo ""
echo "Each time you run this script all git repositories will get updated to their latest versions!"
echo ""
echo -e "${BLUE}Updating from git, please wait ...${NC}"
echo ""
SCRIPTPATH="$( cd "$(dirname "$0")" ; pwd -P )"
cd "${SCRIPTPATH}"
git pull
git submodule sync
git submodule update --init
echo ""
echo -e "${BLUE}Done!${NC}"
echo ""
METAS="$( ls | grep meta- | tr '\n' ' ' | sed 's/ $//g' )"
git pull
# rm -f ${BUILDDIR}/env.source
rm -f ${BUILDDIR}/conf/local.conf
rm -f ${BUILDDIR}/conf/openvision.conf
sed -i "s#BUILD_DIR = \$(CURDIR)/.*#BUILD_DIR = \$(CURDIR)/${BUILDDIR}#g" Makefile
echo ""
echo -e "${BLUE}Done.${NC}"
