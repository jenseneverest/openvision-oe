INHIBIT_DEFAULT_DEPS = "1"
LICENSE = "GPLv2 & LGPLv2.1"
HOMEPAGE = "http://www.eglibc.org/"

# This needs to match with glibc.inc, otherwise glibc-scripts and glibc-locale
# will fail to find main glibc, for details see
# http://lists.openembedded.org/pipermail/openembedded-core/2015-January/100679.html
ARM_INSTRUCTION_SET = "arm"

deltask do_fetch
deltask do_unpack
deltask do_patch
do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install[depends] += "virtual/${MLPREFIX}libc:do_stash_locale"

COMPATIBLE_HOST_libc-musl_class-target = "null"
COMPATIBLE_HOST_libc-uclibc_class-target = "null"
