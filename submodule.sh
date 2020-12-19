#!/bin/sh
echo ""
RED='\033[0;31m'
NC='\033[0m' # No Color
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[0;33m'
echo "This is only for Open Vision developers with push access"
echo ""
echo -e "First choose what kind of submodule update do you want?"
echo -e "Answers are in ${GREEN}green:${NC}"
echo -e "${GREEN}All ${NC}- ${GREEN}Specific ${NC}- ${RED}BitBake ${NC}- ${RED}OpenEmbedded ${NC}- ${RED}Core ${NC}- ${RED}QT5"
echo -e ""
echo -e "${NC}Enter submodule type:${GREEN}"
echo -e ""
read SUBMODULETYPE
echo -e "${NC}"
if [ $SUBMODULETYPE != "All" -a $SUBMODULETYPE != "Specific" -a $SUBMODULETYPE != "BitBake" -a $SUBMODULETYPE != "OpenEmbedded" -a $SUBMODULETYPE != "Core" -a $SUBMODULETYPE != "QT5" ]
then
	echo -e "${RED}Not a valid answer!${NC}"
	echo -e ""
	exit 0
fi
echo "Stage 1: git pull for new changes"
echo ""
if [ $SUBMODULETYPE = "Specific" ]
then
	echo -e "${NC}Enter submodule name without meta-:${GREEN}"
	echo -e ""
	read SUBMODULENAME
	echo -e "${NC}"
	cd meta-${SUBMODULENAME}
	echo "Checking out meta-${SUBMODULENAME} develop branch:"
	git checkout develop
	git pull
	echo -e "\n"
	cd ..
	echo "Stage 2: git add for new changes"
	echo ""
	git add meta-${SUBMODULENAME}
	git commit --dry-run
	read -p "The above changes will be committed and pushed to Open Vision, [A]bort [P]roceed: " choice
	if [ "$choice" = "P" -o "$choice" = "p" ];then
		git commit -S -m "Update meta-${SUBMODULENAME} submodule using submodule.sh"
		echo "Stage 3: git push for new changes"
		echo ""
		git push
		echo "Done: the repository got updated to its latest version!"
		echo ""
	else 
		exit 0
	fi
fi
if [ $SUBMODULETYPE = "BitBake" ]
then
	cd bitbake
	echo "Checking out bitbake 1.34 branch:"
	git checkout 1.34
	git pull
	echo -e "\n"
	cd ..
	echo "Stage 2: git add for new changes"
	echo ""
	git add bitbake
	git commit --dry-run
	read -p "This is serious, if you don't know what is this or you're not 100% sure about it just [A]bort otherwise the above changes will be committed and pushed to Open Vision and the result could be catastrophic, [P]roceed? " choice
	if [ "$choice" = "P" -o "$choice" = "p" ];then
		git commit -S -m "Update bitbake submodule using submodule.sh"
		echo "Stage 3: git push for new changes"
		echo ""
		git push
		echo "Done: the repository got updated to its latest version!"
		echo ""
	else 
		exit 0
	fi
fi
if [ $SUBMODULETYPE = "OpenEmbedded" ]
then
	cd meta-openembedded
	echo "Checking out meta-openembedded pyro branch:"
	git checkout pyro
	git pull
	echo -e "\n"
	cd ..
	echo "Stage 2: git add for new changes"
	echo ""
	git add meta-openembedded
	git commit --dry-run
	read -p "This is serious, if you don't know what is this or you're not 100% sure about it just [A]bort otherwise the above changes will be committed and pushed to Open Vision and the result could be catastrophic, [P]roceed? " choice
	if [ "$choice" = "P" -o "$choice" = "p" ];then
		git commit -S -m "Update meta-openembedded submodule using submodule.sh"
		echo "Stage 3: git push for new changes"
		echo ""
		git push
		echo "Done: the repository got updated to its latest version!"
		echo ""
	else 
		exit 0
	fi
fi
if [ $SUBMODULETYPE = "Core" ]
then
	cd openembedded-core
	echo "Checking out openembedded-core pyro branch:"
	git checkout pyro
	git pull
	echo -e "\n"
	cd ..
	echo "Stage 2: git add for new changes"
	echo ""
	git add openembedded-core
	git commit --dry-run
	read -p "This is serious, if you don't know what is this or you're not 100% sure about it just [A]bort otherwise the above changes will be committed and pushed to Open Vision and the result could be catastrophic, [P]roceed? " choice
	if [ "$choice" = "P" -o "$choice" = "p" ];then
		git commit -S -m "Update openembedded-core submodule using submodule.sh"
		echo "Stage 3: git push for new changes"
		echo ""
		git push
		echo "Done: the repository got updated to its latest version!"
		echo ""
	else 
		exit 0
	fi
fi
if [ $SUBMODULETYPE = "QT5" ]
then
	cd meta-qt5
	echo "Checking out meta-qt5 pyro branch:"
	git checkout pyro
	git pull
	echo -e "\n"
	cd ..
	echo "Stage 2: git add for new changes"
	echo ""
	git add meta-qt5
	git commit --dry-run
	read -p "This is serious, if you don't know what is this or you're not 100% sure about it just [A]bort otherwise the above changes will be committed and pushed to Open Vision and the result could be catastrophic, [P]roceed? " choice
	if [ "$choice" = "P" -o "$choice" = "p" ];then
		git commit -S -m "Update meta-qt5 submodule using submodule.sh"
		echo "Stage 3: git push for new changes"
		echo ""
		git push
		echo "Done: the repository got updated to its latest version!"
		echo ""
	else 
		exit 0
	fi
fi
if [ $SUBMODULETYPE = "All" ]
then
	cd meta-az
	echo "Checking out meta-az develop branch:"
	git checkout develop
	git pull
	echo -e "\n"
	cd ..
	cd meta-cube
	echo "Checking out meta-cube develop branch:"
	git checkout develop
	git pull
	echo -e "\n"
	cd ..
	cd meta-dm
	echo "Checking out meta-dm develop branch:"
	git checkout develop
	git pull
	echo -e "\n"
	cd ..
	cd meta-gb
	echo "Checking out meta-gb develop branch:"
	git checkout develop
	git pull
	echo -e "\n"
	cd ..
	cd meta-hypercube
	echo "Checking out meta-hypercube develop branch:"
	git checkout develop
	git pull
	echo -e "\n"
	cd ..
	cd meta-linkdroid
	echo "Checking out meta-linkdroid develop branch:"
	git checkout develop
	git pull
	echo -e "\n"
	cd ..
	cd meta-odroid
	echo "Checking out meta-odroid develop branch:"
	git checkout develop
	git pull
	echo -e "\n"
	cd ..
	cd meta-wetek
	echo "Checking out meta-wetek develop branch:"
	git checkout develop
	git pull
	echo -e "\n"
	cd ..
	echo "Stage 2: git add for new changes"
	echo ""
	git add meta-*
	git commit --dry-run
	read -p "The above changes will be committed and pushed to Open Vision, [A]bort [P]roceed: " choice
	if [ "$choice" = "P" -o "$choice" = "p" ];then
		git commit -S -m "Update submodules using submodule.sh"
		echo "Stage 3: git push for new changes"
		echo ""
		git push
		echo "Done: all git repositories got updated to their latest versions!"
		echo ""
	else 
		exit 0
	fi
fi
