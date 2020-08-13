MAINTAINER = "Narcis Ilisei"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=3c34afdc3adf82d2448f12715a255122"

PV = "v.02.24.44"

SRC_URI = "${SOURCEFORGE_MIRROR}/${BPN}/${BPN}/${BPN}.${PV}/${BPN}.${PV}.tar.gz \
    file://inadyn-mt.sh \
    file://inadyn.conf \
    file://remove_host_include_paths.patch \
    file://inadyn-mt-ip6-127.0.0.1-00-02.24.44.patch \
    "

SRC_URI[md5sum] = "0652d99aab1249d6a3afe4d65861e77b"
SRC_URI[sha256sum] = "f894b5ab92ed4ec4cae2eccc99efef1aa18c0f5f02de66025e50833cc9063c3c"

S = "${WORKDIR}/${BPN}.${PV}"

inherit autotools-brokensep update-rc.d

INITSCRIPT_NAME = "inadyn-mt"
CONFFILES_${PN} = "${sysconfdir}/inadyn.conf"

do_compile() {
    make -f makefile-deprecated
}

do_install() {
    install -d ${D}${bindir}
    install -m 755 ${S}${base_bindir}/linux/inadyn-mt ${D}${bindir}
    install -d ${D}${sysconfdir}
    install -m 644 ${WORKDIR}/inadyn.conf ${D}${sysconfdir}/
    install -d ${D}${sysconfdir}/init.d
    install -m 755 ${WORKDIR}/inadyn-mt.sh ${D}${sysconfdir}/init.d/inadyn-mt
}

INSANE_SKIP_${PN} += "ldflags"