SUMMARY = "satip client using vtuner"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c1c00f9d3ed9e24fa69b932b7e7aff2"
PACKAGE_ARCH = "${MACHINE_ARCH}"

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

SRC_URI = " \
    git://github.com/OpenVisionE2/satip-client.git;protocol=git \
    file://satipclient.sh \
    ${@bb.utils.contains("MACHINE_FEATURES", "oldkernel", "file://satipclient_oldkernel.patch", "", d)} \
"

SRC_URI_append_arm += "file://0001-auto-detect-and-avoid-ioctl-conflicts.patch"

S = "${WORKDIR}/git"

inherit gitpkgv autotools update-rc.d

INITSCRIPT_NAME = "satipclient"
INITSCRIPT_PARAMS = "defaults"

do_install_append() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/satipclient.sh ${D}${sysconfdir}/init.d/satipclient
}

EXTRA_OECONF = " \
    --with-boxtype=${MACHINE} \
    --with-boxbrand=${BOX_BRAND} \
    "
