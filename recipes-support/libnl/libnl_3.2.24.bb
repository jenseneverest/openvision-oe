SUMMARY = "A library for applications dealing with netlink sockets"
HOMEPAGE = "http://www.infradead.org/~tgr/libnl/"
SECTION = "libs/network"
PACKAGE_ARCH := "${MACHINE_ARCH}"

PE = "1"

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

DEPENDS = "flex-native bison-native"

SRC_URI = "http://www.infradead.org/~tgr/${BPN}/files/${BP}.tar.gz \
           file://fix-pktloc_syntax_h-race.patch \
           file://fix-pc-file.patch \
           file://fix-lib-cache_mngr.c-two-parentheses-bugs.patch \
           file://tc_ematch-header-files.patch \
           file://nl80211-header.patch \
           file://stubs-o32_hard.h \
          "
SRC_URI[md5sum] = "6e0e7bad0674749d930dd9f285343d55"
SRC_URI[sha256sum] = "fb8d6e5dc8af5b85bc6d00a71582a68a01e6a3f7d1664d4a646e289a99dd6816"

inherit autotools-brokensep pkgconfig

FILES_${PN} = "${libdir}/libnl-3.so.* \
               ${libdir}/libnl.so.* \
               ${sysconfdir}"

RREPLACES_${PN} = "libnl2"
RCONFLICTS_${PN} = "libnl2"

FILES_${PN}-dev += "${libdir}/libnl/cli/*/*.so \
                    ${libdir}/libnl/cli/*/*.la"

FILES_${PN}-staticdev += "${libdir}/libnl/cli/*/*.a"

PACKAGES += "${PN}-cli ${PN}-route ${PN}-nf ${PN}-genl ${PN}-idiag"

FILES_${PN}-cli   = "${libdir}/libnl-cli-3.so.* \
                     ${libdir}/libnl/cli/*/*.so.* \
                     ${sbindir}/nl-*"

FILES_${PN}-route = "${libdir}/libnl-route-3.so.*"

FILES_${PN}-idiag = "${libdir}/libnl-idiag-3.so.*"

FILES_${PN}-nf    = "${libdir}/libnl-nf-3.so.*"

FILES_${PN}-genl  = "${libdir}/libnl-genl-3.so.* \
                     ${libdir}/libnl-genl.so.* \
                     ${sbindir}/genl-ctrl-list"
RREPLACES_${PN}-genl = "libnl-genl2 libnl-genl-3-200"
RCONFLICTS_${PN}-genl = "libnl-genl2 libnl-genl-3-200"

do_install_append() {
    install -m 0755 -d ${D}${includedir}/linux
    install -m 0755 -d ${D}${includedir}/linux/tc_ematch
    install -m 0644 ${S}/include/linux/nl80211.h ${D}${includedir}/linux/nl80211.h
    install -m 0644 ${S}/include/linux/tc_ematch/tc_em_cmp.h   ${D}${includedir}/linux/tc_ematch/tc_em_cmp.h
    install -m 0644 ${S}/include/linux/tc_ematch/tc_em_nbyte.h ${D}${includedir}/linux/tc_ematch/tc_em_nbyte.h
    install -m 0644 ${S}/include/linux/tc_ematch/tc_em_text.h  ${D}${includedir}/linux/tc_ematch/tc_em_text.h
    install -m 0755 -d ${D}${includedir}/gnu
    install -m 0644 ${WORKDIR}/stubs-o32_hard.h  ${D}${includedir}/gnu/stubs-o32_hard.h
}

FILES_${PN}-dev_append = " ${includedir}/linux/tc_ematch/*.h ${includedir}/linux/nl80211.h"
INSANE_SKIP_${PN}-dev = "dev-elf"
