inherit allarch
require conf/license/license-close.inc
LICENSE = "CLOSED"
PACKAGES = "${PN}"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
FILES_${PN} += "${nonarch_base_libdir}/firmware"
