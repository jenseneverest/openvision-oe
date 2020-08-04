FILESEXTRAPATHS_prepend := "${THISDIR}/qtwebkit-git:"

SRC_URI += "\
	file://Enable-NPAPI-for-Qt-without-X11.patch \
	"

PACKAGE_ARCH := "${MACHINE_ARCH}"
