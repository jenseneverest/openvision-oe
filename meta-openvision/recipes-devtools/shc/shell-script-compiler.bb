SUMMARY = "Shell script compiler"
MAINTAINER = "Md Jahidul Hamid"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

inherit autotools-brokensep gitpkgv

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/neurobin/shc.git;protocol=http;branch=release"

S = "${WORKDIR}/git"

PROVIDES = "${PN}"

PACKAGES = "${PN}"

do_package_qa() {
}

EXTRA_OECONF = " \
    BUILD_SYS=${BUILD_SYS} \
    HOST_SYS=${HOST_SYS} \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR} \
    "
