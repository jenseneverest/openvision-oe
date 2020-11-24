SUMMARY = "Driver for Realtek USB wireless device 8192fu"
HOMEPAGE = "http://www.realtek.com/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7fc9206801c1cb9a93c37d7dc0667d87"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS ="bc-native"

SRC_URI = "git://github.com/atvcaptain/RTL8192FU.git;branch=main"

S = "${WORKDIR}/git"

inherit module machine_kernel_pr

EXTRA_OEMAKE = "LINUX_SRC=${STAGING_KERNEL_DIR} KDIR=${STAGING_KERNEL_DIR} KSRC=${STAGING_KERNEL_DIR}"

do_install() {
        install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
        install -m 0644 ${S}/8192fu.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
}
