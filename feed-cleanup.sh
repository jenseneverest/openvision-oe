#!/bin/sh
echo ""
RED='\033[0;31m'
NC='\033[0m' # No Color
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[0;33m'
rm -f build/bitbake.lock
echo -e "Welcome to Open Vision's feed cleanup script!"
echo -e ""
echo -e "After using this script the size of the ipk folder will be reduced."
echo -e ""
echo -e "This is good for uploads as nobody uses:"
echo -e "-dbg_ -dev_ -doc_ -staticdev_ -src_ -po_ packages anyway."
echo -e ""
echo -e "Removing extra ipk files, it could take minutes so please wait ..."
#find build/tmp/deploy/ipk -type f \( -iname \*-dbg_* -o -iname \*-dev_* -o -iname \*-doc_* -o -iname \*-staticdev_* -o -iname \*-src_* -o -iname \*-po_* \) -exec rm -f {} \;
echo ""
echo "Done."
