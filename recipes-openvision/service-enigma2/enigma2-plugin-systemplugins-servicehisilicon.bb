DESCRIPTION = "hisilicon service for enigma2"
AUTHOR = "zgemma-star"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES += "virtual/enigma2-mediaservice"
RPROVIDES_${PN} += "virtual/enigma2-mediaservice"

DEPENDS = "enigma2"
RDEPENDS_${PN} = "enigma2"

SRC_URI = "git://github.com/OpenVisionE2/servicehisilicon.git;branch=master"

S = "${WORKDIR}/git"

inherit autotools gitpkgv pythonnative pkgconfig gettext rm_python_pyc compile_python_pyo no_python_src

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

EXTRA_OECONF = "\
	BUILD_SYS=${BUILD_SYS} \
	HOST_SYS=${HOST_SYS} \
	STAGING_INCDIR=${STAGING_INCDIR} \
	STAGING_LIBDIR=${STAGING_LIBDIR} \
	"

FILES_${PN} += "\
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceHisilicon/*.pyo \
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceHisilicon/*.png \
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceHisilicon/*/*/*/*.mo \
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceHisilicon/servicehisilicon.so"

FILES_${PN}-dev += "\
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceHisilicon/servicehisilicon.la"
