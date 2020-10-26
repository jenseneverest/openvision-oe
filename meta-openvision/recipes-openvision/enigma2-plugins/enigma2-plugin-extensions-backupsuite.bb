DESCRIPTION = "Backup Suite for Open Vision"
LICENSE = "GPLv3"
AUTHOR = "Pedro Newbie <pedro.newbie@gmail.com>"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/OpenVisionE2/BackupSuite.git;branch=develop;protocol=git"

# don't inherit allarch, it can't work with arch-dependent RDEPENDS
inherit gitpkgv distutils-openplugins gettext

RDEPENDS_${PN} = "\
	mtd-utils \
	mtd-utils-ubifs \
	${@bb.utils.contains("IMAGE_FSTYPES", "tar.bz2", "bzip2" , "", d)} \
	${@bb.utils.contains_any("IMAGE_FSTYPES", "jffs2nfi ubinfi", "dreambox-buildimage mtd-utils-jffs2" , "", d)} \
	enigma2-plugin-systemplugins-mphelp \
	"

S = "${WORKDIR}/git"

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"
