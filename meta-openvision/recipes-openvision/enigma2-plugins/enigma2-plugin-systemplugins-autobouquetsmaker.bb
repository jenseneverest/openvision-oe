SUMMARY = "Automatically build and update bouquets from the DVB stream."
DESCRIPTION = "Automatically build and update bouquets from the DVB stream."
MAINTAINER = "oe-alliance team"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

DEPENDS = "enigma2"

inherit autotools-brokensep gitpkgv pythonnative gettext rm_python_pyc compile_python_pyo no_python_src

PV = "3.1+git${SRCPV}"
PKGV = "3.1+git${GITPKGV}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI = "\
	git://github.com/oe-alliance/AutoBouquetsMaker.git;protocol=git \
	file://openvision.patch \
	"

S = "${WORKDIR}/git"

EXTRA_OECONF = " \
    BUILD_SYS=${BUILD_SYS} \
    HOST_SYS=${HOST_SYS} \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR} \
    "

pkg_preinst_${PN}_prepend() {
#!/bin/sh
echo "Checking for an ABM cache file"

if [ -f ${libdir}/enigma2/python/Plugins/SystemPlugins/AutoBouquetsMaker/providers/providers.cache ]; then
	rm -f ${libdir}/enigma2/python/Plugins/SystemPlugins/AutoBouquetsMaker/providers/providers.cache > /dev/null 2>&1
	echo "Cache file has been removed"
else
	echo "No cache file found, continuing."
fi
}
