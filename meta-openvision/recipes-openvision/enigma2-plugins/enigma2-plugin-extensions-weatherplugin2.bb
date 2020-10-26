DESCRIPTION = "WeatherPlugin2 by Dr.Best modified by RAED"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit gitpkgv distutils-openplugins gettext

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

SRC_URI = "git://github.com/OpenVisionE2/WeatherPlugin2.git;protocol=git"

FILES_${PN} = "${libdir}"

RDEPENDS_${PN} = "enigma2-plugin-skincomponents-weathercomponent enigma2-plugin-systemplugins-weathercomponenthandler"

S = "${WORKDIR}/git"
