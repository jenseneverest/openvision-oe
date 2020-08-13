SUMMARY = "Drivers for grautec oled display for dreambox"
MAINTAINER = "grautec"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"
require conf/license/license-gplv2.inc

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit gitpkgv

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

INHIBIT_PACKAGE_STRIP = "1"

SRC_URI="git://github.com/openatv/grautec.git"

S = "${WORKDIR}/git"

FILES_${PN} = "${prefix}/* ${sysconfdir}"
FILES_${PN}-dbg = "${sysconfdir}/grautec/*/.debug/*.ko"

do_install() {
    install -d ${D}${sysconfdir}/init.d
    install -d ${D}${sysconfdir}/rc3.d
    install -d ${D}${sysconfdir}/rc6.d
    chmod -R 777 ${S}/dreambox
    cp -rp ${S}/dreambox/* ${D}/
    ln -sf ../init.d/usbtftdisplay.sh ${D}${sysconfdir}/rc3.d/S90usbtftdisplay
    ln -sf ../init.d/killusbtftdisplay.sh ${D}${sysconfdir}/rc6.d/K50killusbtftdisplay
}

do_package_qa() {
}
