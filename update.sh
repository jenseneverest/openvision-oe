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
echo -e "${BLUE}Is there a merge conflict with PLi's repos?"
echo -e "Answers are in ${GREEN}green:${NC}"
echo -e ""
echo -e "${GREEN}No ${NC}- ${GREEN}Yes"
echo -e ""
echo -e "${BLUE}Enter conflict mode:${NC}"
echo -e "${GREEN}"
read CONFLICTMODE
echo -e "${NC}"
if [ $CONFLICTMODE != "Yes" -a $CONFLICTMODE != "No" ]
then
	echo -e "${BLUE}Not a valid answer!${NC}"
	echo -e ""
	exit 0
fi
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
cd ..
if [ $CONFLICTMODE = "No" ]
then
	git pull
fi
if [ $CONFLICTMODE = "Yes" ]
then
	# Lets restore everything first.
	git checkout .
	# Clear the modifications we've done to the submodules before updating.
	git submodule foreach git checkout .
	git pull --rebase
fi
cat openvision-oe/Makefile-Vision > Makefile
sed -i "s#BUILD_DIR = \$(CURDIR)/.*#BUILD_DIR = \$(CURDIR)/${BUILDDIR}#g" Makefile
echo ""
# Regenerate bblayers.conf so we can add our own
rm -f ${BUILDDIR}/conf/bblayers.conf
make init update
echo ""
for i in ${METAS}
do
    echo "BBLAYERS_append = \" ${SCRIPTPATH}/${i}\"" >> ${BUILDDIR}/conf/bblayers.conf
done
echo "BBLAYERS_append = \" ${SCRIPTPATH}\"" >> ${BUILDDIR}/conf/bblayers.conf
cp -f openvision-oe/conf/license/LICENSE-CLOSE meta-openpli/licenses
rm -rf meta-openpli/recipes-connectivity/mediatek
rm -rf meta-openpli/recipes-connectivity/openssl/libcrypto-compat_1.0.2.bb
rm -rf meta-openpli/recipes-connectivity/realtek
rm -rf meta-openpli/recipes-core/base-files
rm -rf meta-openpli/recipes-core/busybox
rm -rf meta-openpli/recipes-extended/tzdata
rm -rf meta-openpli/recipes-linux
rm -rf meta-openpli/recipes-multimedia/tuxtxt
rm -rf meta-openpli/recipes-openpli
